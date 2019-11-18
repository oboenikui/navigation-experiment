package com.oboenikui.navigationsample.feature.trend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.oboenikui.navigationsample.domain.model.Content
import com.oboenikui.navigationsample.domain.model.Trend
import com.oboenikui.navigationsample.navigator.CommonNavigator
import javax.inject.Inject

class TrendAdapter @Inject constructor(
    private val trends: List<Trend>,
    private val navController: NavController
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val viewTypes by lazy {
        trends.withIndex().flatMap { (index, trend) ->
            listOf(ViewTypeHolder(VIEW_TYPE_TITLE, index to 0)) +
                    trend.contents.mapIndexed { contentIndex, _ ->
                        ViewTypeHolder(VIEW_TYPE_CONTENT, index to contentIndex)
                    }
        }
    }

    override fun getItemCount() = trends.fold(0) { prev, trend -> trend.contents.size + 1 + prev }

    override fun getItemViewType(position: Int) = viewTypes[position].viewType

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_TITLE -> TitleViewHolder(
                inflater.inflate(
                    R.layout.item_trend_title,
                    parent,
                    false
                )
            )
            VIEW_TYPE_CONTENT -> ContentViewHolder(
                inflater.inflate(
                    R.layout.item_trend_content,
                    parent,
                    false
                )
            )
            else -> error("Unexpected view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val (trendIndex, contentIndex) = viewTypes[position].index
        when (holder) {
            is TitleViewHolder -> holder.bind(trends[trendIndex].name)
            is ContentViewHolder -> holder.bind(trends[trendIndex].contents[contentIndex], navController)
        }
    }

    companion object {
        private const val VIEW_TYPE_TITLE = 0
        private const val VIEW_TYPE_CONTENT = 1
    }
}

data class ViewTypeHolder(
    val viewType: Int,
    val index: Pair<Int, Int>
)

class TitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val titleView by lazy {
        itemView.findViewById<TextView>(R.id.titleView)
    }

    fun bind(trendName: String) {
        titleView.text = trendName
    }
}

class ContentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val bodyView by lazy {
        itemView.findViewById<TextView>(R.id.bodyView)
    }
    private val accountNameView by lazy {
        itemView.findViewById<TextView>(R.id.accountNameView)
    }

    fun bind(content: Content, navController: NavController) {
        accountNameView.text = content.account.name
        bodyView.text = content.body

        // TODO change to better solution
        itemView.setOnClickListener {
            navController.navigate(TrendFragmentDirections.actionTrendToDetail(content))
        }
    }
}
