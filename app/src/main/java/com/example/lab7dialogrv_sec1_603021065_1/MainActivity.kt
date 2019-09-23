package com.example.lab7dialogrv_sec1_603021065_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.*
import layout.Student
import layout.StudentsAdapter

class MainActivity : AppCompatActivity() {
    val studentList:ArrayList<Student> = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testStudentData()
        recycler_view.adapter = StudentsAdapter(this.studentList,applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext) as RecyclerView.LayoutManager?
        recycler_view.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?
    }
    fun addStudent(v: View) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setView(mDialogView)
        val mAlertDialog = mBuilder.show()

        mDialogView.btnAdd.setOnClickListener {
            studentList.add(
                Student(
                    mDialogView.edt_id.text.toString(), mDialogView.edt_name.text.toString(),
                    mDialogView.edt_age.text.toString().toInt()
                )
            )
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(
                applicationContext,
                "The student is added successfully",
                Toast.LENGTH_SHORT
            ).show()
            mAlertDialog.dismiss()

        }
        mDialogView.btnCancle.setOnClickListener() {
            mAlertDialog.dismiss()
        }

    }

    fun testStudentData() {
        studentList.add(Student("60302065-1", "Student 1", 20))
        studentList.add(Student("60302065-1", "Student 2", 20))
    }
}
