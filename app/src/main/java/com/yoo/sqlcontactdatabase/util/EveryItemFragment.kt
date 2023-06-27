package com.yoo.sqlcontactdatabase.util

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.widget.ToolbarWidgetWrapper
import androidx.navigation.fragment.findNavController
import com.yoo.sqlcontactdatabase.R

class EveryItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_every_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var bar=view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolBar)

        bar.setNavigationOnClickListener{
            findNavController().popBackStack()
        }
    }


}