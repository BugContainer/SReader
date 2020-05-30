package com.bugli.sreader.ui.bookself

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bugli.sreader.R
import kotlinx.android.synthetic.main.booself.*

class BookSelfFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.booself, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView = bookSelf_rv
        val layoutManager: LinearLayoutManager = LinearLayoutManager(context)
        layoutManager.orientation  = GridLayoutManager.HORIZONTAL

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter =

    }


}