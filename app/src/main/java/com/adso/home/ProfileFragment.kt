package com.adso.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val publicacionesTextView = view.findViewById<TextView>(R.id.publicacionesTextView)
        val calificacionesTextView = view.findViewById<TextView>(R.id.calificacionesTextView)
        val skillsTextView = view.findViewById<TextView>(R.id.skillsTextView)

        publicacionesTextView.setOnClickListener {
            // Aquí puedes manejar el clic del TextView de publicaciones
            // Puedes abrir una nueva actividad o realizar otra acción según lo necesario
        }
        calificacionesTextView.setOnClickListener {
            val intent = Intent(requireContext(), CalificacionActivity::class.java)
            startActivity(intent)
        }
        skillsTextView.setOnClickListener {
            val intent = Intent(requireContext(), SkillsActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}