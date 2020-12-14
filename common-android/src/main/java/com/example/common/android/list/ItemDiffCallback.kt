package com.example.common.android.list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import java.util.Objects

class ItemDiffCallback<I : Item> : DiffUtil.ItemCallback<I>() {
    override fun areItemsTheSame(oldItem: I, newItem: I): Boolean {
        return oldItem.uniqueId() == newItem.uniqueId()
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun areContentsTheSame(oldItem: I, newItem: I): Boolean {
        return Objects.equals(oldItem, newItem)
    }
}
