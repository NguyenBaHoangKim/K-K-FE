package com.example.k_k_application.fragment.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.k_k_application.R
import com.example.k_k_application.common.https.userAPI.UserApiManager
import com.example.k_k_application.databinding.FragmentDashboardBinding
import com.example.k_k_application.model.User

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null

    private lateinit var button: Button
    private val userApiManager by lazy { UserApiManager() }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val dashboardViewModel =
//            ViewModelProvider(this).get(DashboardViewModel::class.java)
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        val textView: TextView = binding.textDashboard
        textView.text = "hihiiii"
        button = root.findViewById(R.id.button)
        button.setOnClickListener {
            fetchUserData(1)
        }
        return root
    }

    fun fetchUserData(id : Long){
        userApiManager.getUserById(id,{data: User ->
            println(data);

        }, { error ->
            println(error)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}