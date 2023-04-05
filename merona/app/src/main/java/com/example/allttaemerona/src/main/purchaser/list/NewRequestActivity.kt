package com.example.allttaemerona.src.main.purchaser.list

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.allttaemerona.config.BaseActivity
import com.example.allttaemerona.databinding.ActivityNewRequestBinding
import com.example.allttaemerona.src.CustomToolbar
import java.io.File

class NewRequestActivity: BaseActivity<ActivityNewRequestBinding>(ActivityNewRequestBinding::inflate) {
    lateinit var imageFile: File

    companion object{
        //갤러리 권한 요청
        const val REQ_GALLERY = 1
    }
    //이미지를 결과값으로 받는 변수
    private val imageResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result ->
       if (result.resultCode == RESULT_OK){
            val imageUri = result.data?.data
           imageUri?.let {
               imageFile = File(getRealPathFromURI(it))

               Glide.with(this)
                   .load(imageUri)
                   .fitCenter()
                   .apply(RequestOptions().override(500,500))
                   .into(binding.ivImage)
           }
       }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //toolbar 뒤로가기 버튼
        val toolbar = binding.toolbar
        toolbar.setOnBackListener(OnBackListener())

        val editTime = binding.tvTimeSetting
        val editPay = binding.tvPaySetting
        var imageSelect = binding.btnPhoto
        var btnCancel = binding.btnCancel
        var btnPost = binding.btnPost

        //number picker 시간
        editTime.setOnClickListener {
            var initNum = 0
            if (editTime.text != null ){
                initNum = editTime.text.toString().toInt()
            }
            val dialog = NumberPickerDialog("시간", initNum, 100, 0, 5)
            dialog.setOnOkClickedListener { content ->
                editTime.text = content.toString()
            }
            dialog.isCancelable = false
            dialog.show(supportFragmentManager, "time" )
        }

        //number picker 가격
        editPay.setOnClickListener{
            var initNum = 0
            if (editPay.text != null ){
                initNum = editPay.text.toString().toInt()
            }
            val dialog = NumberPickerDialog("배송료", initNum, 10000, 0, 500)
            dialog.setOnOkClickedListener { content ->
                editPay.text = content.toString()
            }
            dialog.isCancelable = false
            dialog.show(supportFragmentManager, "pay" )
        }

        //사진 등록 버튼
        imageSelect.setOnClickListener {
            selectGallery()
        }

        //요청 작성 취소 버튼
        btnCancel.setOnClickListener {
            finish()
        }

        //요청 등록 버튼 (추후 기능 추가)
        btnPost.setOnClickListener {
            finish()
        }
    }

    //toolbar 뒤로가기 버튼
    inner class OnBackListener : CustomToolbar.OnBackListener {
        override fun onClick(view: View) {
            finish()
        }
    }

    //갤러리 호출
    private fun selectGallery(){
        val writePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

        if (writePermission == PackageManager.PERMISSION_DENIED ||
                readPermission == PackageManager.PERMISSION_DENIED) {
            //권한 요청
            ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE), REQ_GALLERY)
        } else {
            //권한이 있는 경우 갤러리 실행
            val intent = Intent(Intent.ACTION_PICK)
            //intent의 data와 type을 동시에 설정하는 매서드
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
            imageResult.launch(intent)
        }
    }
}