package com.ubaya.layouttester

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ubaya.layouttester.databinding.MovieItemBinding

class MovieAdapter(): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(val binding:MovieItemBinding):RecyclerView.ViewHolder(binding.root)

    private lateinit var binding: MovieItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding=MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Global.movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val url = Global.movies[position].url
        val builder = Picasso.Builder(holder.itemView.context)
        builder.listener {picasso, uri, exeption -> exeption.printStackTrace()}
//        Picasso.get().load(url).into(holder.binding.imageView4)
//        holder.binding.textView.text = Global.movies[position].title
//        holder.binding.textView3.text = Global.movies[position].rating
//        holder.binding.textView2.text = Global.movies[position].showDate
        with(holder.binding){
            Picasso.get().load(url).into(imgPoster)
            txtTitle.text = Global.movies[position].title
            txtRating.text = Global.movies[position].rating
            txtShowDate.text = Global.movies[position].showDate


            btnDelete.setOnClickListener{
                val builder = AlertDialog.Builder(it.context)
                builder.setMessage("Delete movie " + Global.movies[position].title + "?")
                builder.setPositiveButton("DELETE", DialogInterface.OnClickListener{dialogInterface, i ->
                    var deletedMovies = Global.movies[position].title
                    Global.movies.removeAt(position)

                    notifyDataSetChanged()

                    Toast.makeText(it.context, deletedMovies + " has been deleted", Toast.LENGTH_SHORT).show()
                })


                builder.setNegativeButton("CANCEL", null)
                builder.create().show()
            }
        }
    }

}