package com.example.cocktailapp.fragment.info

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.content.Intent.createChooser
import android.provider.Settings.Global.getString

import android.view.View.OnClickListener
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.example.cocktailapp.App
import com.example.cocktailapp.R

import android.net.Uri
import android.view.View
import com.example.cocktailapp.fragment.Action

import kotlinx.android.synthetic.main.fragment_info.*



class InfoViewModel : ViewModel() {



    init {
        App.appComponent.inject(this)
    }






}
