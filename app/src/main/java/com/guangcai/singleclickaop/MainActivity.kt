package com.guangcai.singleclickaop

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.guangcai.singleclick.SingleClick
import com.guangcai.singleclick.click
import com.guangcai.singleclick.setSingleCLickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClick.setOnClickListener(this)
        initView()
    }
    private fun initView() {
        btnKuoZhan.setSingleCLickListener {
            Toast.makeText(this,"啊啊啊啊",Toast.LENGTH_SHORT).show()
        }

        btnKuoZhanClick.click {
            Toast.makeText(this,"呵呵呵呵",Toast.LENGTH_SHORT).show()
        }
    }


    @SingleClick(800)
    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.btnClick->{
                    Toast.makeText(this,"哈哈哈哈",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}