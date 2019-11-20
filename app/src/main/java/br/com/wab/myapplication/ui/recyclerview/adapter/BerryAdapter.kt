package br.com.wab.myapplication.ui.recyclerview.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.wab.myapplication.R
import br.com.wab.myapplication.model.GenericResultsResponse
import kotlinx.android.synthetic.main.item_berry.view.*

class BerryAdapter(
    val context: Context,
    var berries: MutableList<GenericResultsResponse> = mutableListOf(),
    var onClickItem: (item: GenericResultsResponse) -> Unit = {}
) : RecyclerView.Adapter<BerryAdapter.BerryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BerryViewHolder {

        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_berry, parent, false)

        return BerryViewHolder(view)
    }

    override fun onBindViewHolder(holder: BerryViewHolder, position: Int) {
        val item = berries[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = berries.size

    inner class BerryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var item: GenericResultsResponse

        init {
            itemView.setOnClickListener {
                if (::item.isInitialized){
                    onClickItem(item)
                }
            }
        }


        fun bind(item: GenericResultsResponse) {
            this.item = item
            itemView.berry_name_content.text = item.name
        }
    }


    fun updateList(newBerries: MutableList<GenericResultsResponse>) {

        val diff = DiffUtil.calculateDiff(object: DiffUtil.Callback(){
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
                    = berries[oldItemPosition] == newBerries[newItemPosition]

            override fun getOldListSize(): Int = berries.size

            override fun getNewListSize(): Int = newBerries.size

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
                    = berries[oldItemPosition].url == newBerries[newItemPosition].url
        })

        this.berries = newBerries
        diff.dispatchUpdatesTo(this@BerryAdapter)
    }


}