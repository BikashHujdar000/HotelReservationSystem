package com.example.hotelreservationsystem.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotelreservationsystem.Models.Room
import com.example.hotelreservationsystem.R
import com.example.hotelreservationsystem.utils.constants.TAG
import com.google.android.material.imageview.ShapeableImageView

class RoomsAdapter(val context:Context ,val RoomData :List<Room>):RecyclerView.Adapter<RoomsAdapter.MyViewHolder>() {

    lateinit var  mlistner :onItemClickListner
     interface onItemClickListner{
         fun onItemClick(position: Int)
       }

  fun setOnItemClickListner(listner: onItemClickListner)
   {
        mlistner = listner
   }

    inner class MyViewHolder(itemView: View,listner: onItemClickListner) : RecyclerView.ViewHolder(itemView) {
        val room_number = itemView.findViewById<TextView>(R.id.room_view_number)
        val room_view_type = itemView.findViewById<TextView>(R.id.room_view_type)
        val room_view_price = itemView.findViewById<TextView>(R.id.room_view_price)
        val room_view_image=itemView.findViewById<ShapeableImageView>(R.id.roomViewImage)
        init {
           itemView.setOnClickListener{
               listner.onItemClick(adapterPosition)
           }
        }

    }
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         val view = LayoutInflater.from(context).inflate(R.layout.rooms_view_layout,parent,false)
         return MyViewHolder(view,mlistner)
     }

     override fun getItemCount(): Int {

         Log.d(TAG, "getItemCount: ${RoomData.size}")

        return  RoomData.size
     }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         Log.d(TAG, "onBindViewHolder called for position: $position")
         holder.room_number.text = RoomData.get(position).number.toString()
         holder.room_view_type.text = RoomData.get(position).type
         holder.room_view_price.text=RoomData.get(position).price.toString()

        // handling the eroor in image
         if(RoomData.get(position).img.isEmpty())
         {
             Glide.with(this.context).load(R.drawable.test).into(holder.room_view_image)
         }
         else
         {
             Glide.with(this.context).load(RoomData.get(position).img).into(holder.room_view_image)
         }
     }
 }

//package com.example.hotelreservationsystem.Adapters
//
//import android.content.Context
//import android.view.LayoutInflater
//
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.hotelreservationsystem.R
//import com.example.hotelreservationsystem.TestModels.DataModel
//
//class TestAdapters (val context :Context,val data: List<DataModel>):RecyclerView.Adapter<TestAdapters.MyViewHolder>() {
//
//lateinit var  mlistner :onItemClickListner
//       interface onItemClickListner{
//           fun onItemClick(position: Int)
//       }
//
//    fun setOnItemClickListner(listner: onItemClickListner)
//    {
//        mlistner = listner
//    }

//    class MyViewHolder(itemview: View, listner: onItemClickListner) : RecyclerView.ViewHolder(itemview)
//    {
//// defining the holder operation
//        val name = itemview.findViewById<TextView>(R.id.hotel_sample_name)
//        val location = itemview.findViewById<TextView>(R.id.hotel_sample_country_name)
//        init {
//            itemview.setOnClickListener {
//                listner.onItemClick(adapterPosition)
//            }
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        // inflating the model layout to the holder
//        val view = LayoutInflater.from(context).inflate(R.layout.test_layout_for_model_view,parent,false)
//        return  MyViewHolder(view,mlistner)
//    }
//
//    override fun getItemCount(): Int {
//            return  data.size
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        // setting name and location from the adapter to the holder
//      holder.name.text = data[position].name
//        holder.location.text = data[position].location
//
//
//    }
//
//}

