package com.oboenikui.navigationsample.feature.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oboenikui.navigationsample.domain.model.Content
import com.oboenikui.navigationsample.domain.model.Trend
import javax.inject.Inject

class HomeAdapter @Inject constructor(
    private val contents: List<Content>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onContentItemClick: ((Content) -> Unit)? = null

    override fun getItemCount() = contents.size

    override fun getItemViewType(position: Int) = VIEW_TYPE_CONTENT

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_CONTENT -> ContentViewHolder(
                inflater.inflate(
                    R.layout.item_home_content,
                    parent,
                    false
                )
            ) { onContentItemClick?.invoke(it) }
            else -> error("Unexpected view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ContentViewHolder -> holder.bind(contents[position])
        }
    }

    companion object {
        private const val VIEW_TYPE_CONTENT = 1
    }
}

class ContentViewHolder(view: View, private val onContentItemClick: (Content) -> Unit) :
    RecyclerView.ViewHolder(view) {
    private val bodyView by lazy {
        itemView.findViewById<TextView>(R.id.bodyView)
    }
    private val accountNameView by lazy {
        itemView.findViewById<TextView>(R.id.accountNameView)
    }

    fun bind(content: Content) {
        accountNameView.text = content.account.name
        bodyView.text = content.body

        itemView.setOnClickListener {
            onContentItemClick(content)
        }
    }
}
