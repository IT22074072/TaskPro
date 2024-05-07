package com.example.taskpro

import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskpro.databinding.ActivityMainBinding
import com.example.taskpro.databinding.AddTaskDialogBinding
import com.example.taskpro.utils.setupDialog

class MainActivity : AppCompatActivity() {

    private val mainBinding:ActivityMainBinding by lazy {
       ActivityMainBinding.inflate(layoutInflater)
    }

    private val addTaskDialog :Dialog by lazy {
        Dialog(this, R.style.DialogCustomTheme).apply {
            setupDialog(R.layout.add_task_dialog)
        }
    }


    private val updateTaskDialog :Dialog by lazy {
        Dialog(this, R.style.DialogCustomTheme).apply {
            setupDialog(R.layout.update_task_dialog)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(mainBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val addCloseImg = addTaskDialog.findViewById<ImageView>(R.id.closeImg)
        val updateCloseImg = updateTaskDialog.findViewById<ImageView>(R.id.closeImg)

        addCloseImg.setOnClickListener{addTaskDialog.dismiss()}
        updateCloseImg.setOnClickListener{updateTaskDialog.dismiss()}

        mainBinding.addTaskFABtn.setOnClickListener{
           addTaskDialog.show()
        }
    }
}