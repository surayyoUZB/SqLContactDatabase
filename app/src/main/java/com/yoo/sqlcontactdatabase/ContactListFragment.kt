package com.yoo.sqlcontactdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoo.sqlcontactdatabase.database.ContactDatabase
import com.yoo.sqlcontactdatabase.databinding.FragmentContactListBinding
import com.yoo.sqlcontactdatabase.model.Contact
import com.yoo.sqlcontactdatabase.Adapter.RvAdapter as RvAdapter

class ContactListFragment : Fragment() {

    private val database by lazy { ContactDatabase(requireContext()) }
    private var _binding: FragmentContactListBinding?=null
    private val binding get() = _binding!!

    private lateinit var rvAdapter:RvAdapter

    private var contact: Contact?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contact = arguments?.get("contact") as Contact?
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        rvAdapter=RvAdapter()

        binding.rv.apply {
            adapter=rvAdapter
            layoutManager=LinearLayoutManager(requireContext())
        }
        rvAdapter.contactList=database.getAllContact().toMutableList()


        rvAdapter.setOnClickListener(
            object : RvAdapter.OnClickListener{
                override fun onClick(position: Int) {
                    findNavController().navigate(R.id.action_contactListFragment_to_everyItemFragment)
                }
            }
        )

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}