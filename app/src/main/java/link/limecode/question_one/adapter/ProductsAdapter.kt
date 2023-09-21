package link.limecode.question_one.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import link.limecode.question_one.R
import link.limecode.question_one.TOTAL
import link.limecode.question_one.binding.util.RecyclerViewHolderBinding
import link.limecode.question_one.databinding.ProductItemBinding
import link.limecode.question_one.model.ProductUIModel

class ProductsAdapter :
    ListAdapter<ProductUIModel, RecyclerViewHolderBinding<ProductItemBinding>>(DiffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewHolderBinding<ProductItemBinding> {
        val binding = ProductItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecyclerViewHolderBinding(binding)
    }

    override fun onBindViewHolder(
        holder: RecyclerViewHolderBinding<ProductItemBinding>,
        position: Int
    ) {
        with(holder.viewBinding) {
            val item = getItem(position)
            tvItemName.text = item.productName
            tvItemPrice.text = root.resources.getString(R.string.template_price, item.productPrice)

            if (item.productName == TOTAL) {
                tvItemName.setTypeface(tvItemName.typeface, Typeface.BOLD)
                tvItemPrice.setTypeface(tvItemPrice.typeface, Typeface.BOLD)
            } else {
                tvItemName.setTypeface(tvItemName.typeface, Typeface.NORMAL)
                tvItemPrice.setTypeface(tvItemPrice.typeface, Typeface.NORMAL)
            }
        }
    }
}

object DiffUtil : DiffUtil.ItemCallback<ProductUIModel>() {
    override fun areItemsTheSame(oldItem: ProductUIModel, newItem: ProductUIModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ProductUIModel, newItem: ProductUIModel): Boolean {
        return oldItem == newItem
    }
}