package com.yoo.sqlcontactdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.yoo.sqlcontactdatabase.database.ContactDatabase
import com.yoo.sqlcontactdatabase.database.DatabaseService
import com.yoo.sqlcontactdatabase.databinding.FragmentAddContactBinding
import com.yoo.sqlcontactdatabase.databinding.FragmentContactListBinding
import com.yoo.sqlcontactdatabase.model.Contact

class AddContactFragment : Fragment() {

    private var _binding: FragmentAddContactBinding?=null
    private val binding get() = _binding!!
    private val database by lazy { ContactDatabase(requireContext()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding= FragmentAddContactBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.btn.setOnClickListener {
            var name=binding.name.text.toString()
            var number=binding.number.text.toString()

            database.saveContact(Contact(0,name,number))
            Toast.makeText(requireContext(), "Kontaktlarga saqlandi", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}