package com.example.cocktailapp.fragment.info

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.cocktailapp.R
import com.example.cocktailapp.databinding.FragmentInfoBinding
import com.example.cocktailapp.fragment.Action
import com.example.cocktailapp.fragment.home.HomeViewModel

/**
 * A simple [Fragment] subclass.
 */
class InfoFragment : Fragment() {


    private val viewModel: InfoViewModel by lazy {
        ViewModelProviders.of(this).get(InfoViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.setTitle("More info")
        // Inflate the layout for this fragment
        val binding: FragmentInfoBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_info, container, false)


        binding.card.setOnClickListener(clickListenerInfoPage(Action.ABOUT))
        binding.card2.setOnClickListener(clickListenerInfoPage(Action.SHARE))
        binding.card3.setOnClickListener(clickListenerInfoPage(Action.CONTACT))


        return binding.root




    }

    private fun clickListenerInfoPage(a: Action): View.OnClickListener = View.OnClickListener {
        when (a) {
            Action.ABOUT -> androidx.appcompat.app.AlertDialog.Builder(it.context).setTitle(R.string.AboutTitle)
                .setMessage(R.string.About)
                .setPositiveButton(R.string.Exit) { dialog, _ -> dialog.dismiss() }
                .create().show()
            Action.SHARE -> {
                val i = Intent().apply {
                    type = "text/plain"
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT,
                            " Download from ${R.string.DOWNLOAD_URL}")
                }
                startActivity(Intent.createChooser(i, getString(R.string.share_using)))
            }
            Action.CONTACT -> {
                val i = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("Mail to shaunivansteyvoort@gmail.com")
                    putExtra(Intent.EXTRA_SUBJECT, R.string.AppName)
                }
                startActivity(Intent.createChooser(i, getString(R.string.send_email_using)))
            }
        }
    }
}
