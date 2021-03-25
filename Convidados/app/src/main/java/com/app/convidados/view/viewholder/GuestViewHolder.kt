package com.app.convidados.view.viewholder

import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.convidados.R
import com.app.convidados.service.model.GuestModel
import com.app.convidados.view.listener.GuestListener
import kotlinx.android.synthetic.main.row_guest.view.*

class GuestViewHolder(itemView: View, private val listener: GuestListener) : RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel) {
        val textName = itemView.textName
        textName.text = guest.name

        textName.setOnClickListener {
            listener.onClick(guest.id)
        }

        textName.setOnLongClickListener {

            AlertDialog.Builder(itemView.context)
                    .setTitle(R.string.remocao_convidado)
                    .setMessage(R.string.deseja_remover)
                    .setPositiveButton(R.string.remover) { dialog, which ->
                        listener.onDelete(guest.id)
                    }
                    .setNeutralButton(R.string.cancelar, null)
                    .show()

            true
        }
    }
}