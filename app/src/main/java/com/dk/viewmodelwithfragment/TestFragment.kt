package com.dk.viewmodelwithfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dk.viewmodelwithfragment.databinding.FragmentTestBinding

/**
 * vm with fragment에서는 프레그먼트가 Activity에 영향을 받기 때문에
 * vm 하나 붙여 넣는다고 값을 유지할수 없다.
 * 즉 MainActivity에서 예외 처리 해줘야 한다.
 */

class TestFragment : Fragment() {

    private lateinit var binding : FragmentTestBinding

    var countVal = 0

    private lateinit var  vm  : TestFragmentVM

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("TestFragment", "onAttach")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TestFragment", "onCreate")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)

        vm = ViewModelProvider(this).get(TestFragmentVM::class.java)

        binding.plus.setOnClickListener {
            vm.plus()
            binding.resultArea.text = vm.getCnt().toString()
//            countVal++
//            binding.resultArea.text = countVal.toString()
        }

        binding.minus.setOnClickListener {
            vm.minus()
            binding.resultArea.text = vm.getCnt().toString()

//            countVal--
//            binding.resultArea.text = countVal.toString()
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Log.d("TestFragment", "onResume")

    }

    override fun onStop() {
        super.onStop()
        Log.d("TestFragment", "onStop")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TestFragment", "onDestroyView")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d("TestFragment", "onDetach")
    }
}