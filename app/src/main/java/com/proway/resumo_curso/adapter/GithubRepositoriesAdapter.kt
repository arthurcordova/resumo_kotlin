package com.proway.resumo_curso

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proway.resumo_curso.databinding.ItemRepositoryBinding
import com.proway.resumo_curso.model.GithubModel

class GithubRepositoriesAdapter : RecyclerView.Adapter<GithubItemViewHolder>() {

    private var listOf = mutableListOf<GithubModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubItemViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false).apply {
            return GithubItemViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: GithubItemViewHolder, position: Int) {
        listOf[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = listOf.size

    /**
     * Aqui sempre irá carregar os items que já estão na lista com os novos que serão recebidos por parametro
     */
    fun refresh(newList: List<GithubModel>) {
        listOf.addAll(newList)
        notifyDataSetChanged()
    }
}

class GithubItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemRepositoryBinding.bind(itemView)

    fun bind(model: GithubModel) {
        binding.textView.text = model.name
        Glide.with(binding.root)
            .load(
                model
                    .owner.avatar
            )
            .into(binding.imageView)
    }


}