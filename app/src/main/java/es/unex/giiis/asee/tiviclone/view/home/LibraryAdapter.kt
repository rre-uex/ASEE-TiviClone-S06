package es.unex.giiis.asee.tiviclone.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.unex.giiis.asee.tiviclone.databinding.LibraryItemListBinding
import es.unex.giiis.asee.tiviclone.data.model.Show
class LibraryAdapter(
    private var shows: List<Show>,
    private val onClick: (show: Show) -> Unit,
    private val onLongClick: (title: Show) -> Unit
) : RecyclerView.Adapter<LibraryAdapter.ShowViewHolder>() {

    class ShowViewHolder(
        private val binding: LibraryItemListBinding,
        private val onClick: (show: Show) -> Unit,
        private val onLongClick: (title: Show) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(show: Show, totalItems: Int) {
            with(binding) {
                tvTitle.text = show.title
            //    tvYear.text = show.year
             //   tvSeasons.text = "${show.seasons} seasons"
                itemImg.setImageResource(show.image)
                clItem.setOnClickListener {
                    onClick(show)
                }
                clItem.setOnLongClickListener {
                    onLongClick(show)
                    true
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val binding =
           LibraryItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowViewHolder(binding, onClick, onLongClick)
    }

    override fun getItemCount() = shows.size

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        holder.bind(shows[position], shows.size)
    }

    fun swap(newShows: List<Show>) {
        shows = newShows
        notifyDataSetChanged()
    }

}