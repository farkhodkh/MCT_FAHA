package com.example.mct_faha.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.example.mct_faha.databinding.ItunesItemLayoutBinding
import com.example.mct_faha.repositories.Repository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itunes_item_layout.view.*


class RepositoryRecyclerViewAdapter(
    private var items: ArrayList<Repository>,
    private var listener: OnItemClickListener
) : RecyclerView.Adapter<RepositoryRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = ItunesItemLayoutBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    //    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val url: String = items[position].trackViewUrl!!

        val imageView: ImageView = holder.itemView.trackView

//        val circularProgressDrawable = CircularProgressDrawable(MainActivity.instance)
//        circularProgressDrawable.strokeWidth = 5f
//        circularProgressDrawable.centerRadius = 30f
//        circularProgressDrawable.start()
//
//        val requestOption: RequestOptions = RequestOptions()
//            .placeholder(circularProgressDrawable)
//            .error(R.drawable.ic_no_photo)
//            .diskCacheStrategy(DiskCacheStrategy.ALL)
//            .priority(Priority.HIGH)
//            .dontAnimate()
//            .dontTransform()
        try {

            //1-Варинат
//            Glide.with(MainActivity.instance)
//                .load(url)
//                .apply(requestOption)
//                .into(imageView!!)
            //2-Вариант
            //imageView.setImageDrawable(MainActivity.instance.getDrawable(R.drawable.ic_no_photo))
            //3-Вариант
            Picasso.get()
                .load(url)
                .resize(500, 500)
                .centerCrop()
                .into(imageView)
            //ОШИБКА: D/skia: --- Failed to create image decoder with message 'unimplemented'
            //ПРИЧИНА: Starting with Android 9.0 (API level 28), cleartext support is disabled by default.

        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return holder.bind(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    fun replaceData(it: ArrayList<Repository>) {
        items.clear()
        items.addAll(it)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(private var binding: ItunesItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: Repository, listener: OnItemClickListener?) {
            binding.repository = repo
            if (listener != null) {
                binding.root.setOnClickListener({ _ -> listener.onItemClick(layoutPosition) })
            }

            binding.executePendingBindings()
        }
    }

}

