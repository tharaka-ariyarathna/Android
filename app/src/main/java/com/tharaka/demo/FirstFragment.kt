package com.tharaka.demo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.tharaka.demo.api.UserApiService
import com.tharaka.demo.databinding.FragmentFirstBinding
import com.tharaka.demo.model.User
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val userApiService = UserApiService.create()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    fun getUserId(): String {
        val id = binding.inputId.text ;
        return id.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
           // findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            val userId = getUserId()
            val user = userApiService.getUser(userId)
            user.enqueue(object : retrofit2.Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    val body = response.body()
                    body?.let{

                        binding.textviewFirst.text = "Name : " + it.name
                        binding.textView2.text = "Email :" + it.email
                        binding.textView3.text = "UserName :" + it.userName
                        binding.textView4.text = "id : " + it.id
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.i("FirstFragment", t.message!!)
                }

            })
        }
    }



   /* override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}