package com.example.candidatecodereview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    val listener: LiveData<Int>
        get() = mutableListener
    private val mutableListener = MutableLiveData<Int>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        multiply.setOnClickListener { multiplyAndUpdateValue() }
    }

    private fun multiplyAndUpdateValue() = MainScope().launch(Dispatchers.IO) {
        mutableListener.apply {
            value = if (value == null)
                INITIAL_VALUE
            else
                value!! * value!!
        }
    }

    companion object {
        private const val INITIAL_VALUE = 2
    }
}
