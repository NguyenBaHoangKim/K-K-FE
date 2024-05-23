package com.example.k_k_application.fragment.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.k_k_application.R
import com.example.k_k_application.adapter.StatusAdapter
import com.example.k_k_application.adapter.UserAdapter
import com.example.k_k_application.common.https.statusApi.StatusApiManager
import com.example.k_k_application.common.https.userAPI.UserApiManager
import com.example.k_k_application.databinding.FragmentDashboardBinding
import com.example.k_k_application.model.Status
import com.example.k_k_application.model.User
import com.example.k_k_application.model.UserRes
import com.example.k_k_application.model.UserStr

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null

    private lateinit var button: Button
    private lateinit var img: ImageView
//    private lateinit var name: TextView
    private lateinit var recyclerView: RecyclerView
    private var mList = ArrayList<UserStr>()
    private var mList2 = ArrayList<Status>()
    private lateinit var recyclerView2: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private lateinit var statusAdapter: StatusAdapter
    private val userApiManager by lazy { UserApiManager() }
    private val statusApiManager = StatusApiManager()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        button = root.findViewById(R.id.button)
        img = root.findViewById(R.id.imageView4)

        recyclerView = root.findViewById(R.id.str)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        recyclerView2 = root.findViewById(R.id.content)
        recyclerView2.setHasFixedSize(true)
        recyclerView2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

//        name.text = "hihiiii"
        button.setOnClickListener {
            testAvt(17)
            fetchData()
        }
        return root
    }
    fun testAvt(id : Long){
        userApiManager.getUserById(id,{data: User ->
            println(data);
            img.setImageBitmap(data.avatarBytes?.toBitMap())
        }, { error ->
            println(error)
        })
    }

    fun fetchData(){
        println("goi tat ca user")
        userApiManager.getUserStr({data: List<UserStr> ->
            for (user in data) {
                if (user.avatar != null) {
                    mList.add(UserStr(user.id, user.username,user.avatar))
                }
            }
            println(mList)
            userAdapter = UserAdapter(mList)
            recyclerView.adapter = userAdapter
        }, { error ->
            println(error)
        })

        println("goi tat ca status")
        statusApiManager.getStatus({data ->
            println(data)
            println("so luong status: ")
            for (status in data) {
                mList2.add(Status(status.statusId, status.userId, status.avt, status.username, status.status, status.img))
            }
            println(mList2.size)
            statusAdapter = StatusAdapter(mList2)
            recyclerView2.adapter = statusAdapter
        }, { error ->
            println(error)
        })
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
