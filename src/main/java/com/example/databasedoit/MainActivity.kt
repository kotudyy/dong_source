package com.example.databasedoit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databasedoit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var dataList = mutableListOf<String>()
    var adapter : RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = RecyclerViewAdapter(dataList)
        binding.TodoList.adapter = adapter
        binding.TodoList.layoutManager = LinearLayoutManager(this)

        binding.btnAdd.setOnClickListener{
            openAddPage()
        }

        val db = DBHelper(this).readableDatabase
        val cursor = db.rawQuery("select * from Todo_TB", null)
        cursor.run {
            while(moveToNext()){
                dataList.add(cursor.getString(1))
                adapter!!.notifyDataSetChanged()
            }
        }
        adapter!!.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu -> openSettingPage()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openAddPage(){
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    private fun openSettingPage() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        val db = DBHelper(this).readableDatabase
        val cursor = db.rawQuery("select * from Todo_TB", null)
        var dataList2 = mutableListOf<String>()
        cursor.run {
            while(moveToNext()){
                dataList2.add(cursor.getString(1))
                adapter!!.setData(dataList2)
            }
        }
        adapter!!.notifyDataSetChanged()
        super.onResume()
    }
}