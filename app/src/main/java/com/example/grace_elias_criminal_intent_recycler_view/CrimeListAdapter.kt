package com.example.grace_elias_criminal_intent_recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.grace_elias_criminal_intent_recycler_view.databinding.ListItemCrimeBinding
import com.example.grace_elias_criminal_intent_recycler_view.databinding.ListItemSeriousCrimeBinding

class CrimeHolder(
    private val binding: ListItemCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

class SeriousCrimeHolder(
    private val binding: ListItemSeriousCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

class CrimeListAdapter(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    enum class CrimeType
    {
        NORMAL, SERIOUS
    }

    override fun getItemViewType(position: Int): Int
    {
        if(crimes[position].requiresPolice)
        {
            return CrimeType.SERIOUS.ordinal
        }
        return CrimeType.NORMAL.ordinal
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)

        if(viewType == CrimeType.NORMAL.ordinal)
        {
            val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
            return CrimeHolder(binding)
        }
        val binding = ListItemSeriousCrimeBinding.inflate(inflater, parent, false)
        return SeriousCrimeHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val crime = crimes[position]

        if(holder is CrimeHolder)
        {
            holder.bind(crime)
        }
        else if(holder is SeriousCrimeHolder)
        {
            holder.bind(crime)
        }
    }

    override fun getItemCount() = crimes.size
}
