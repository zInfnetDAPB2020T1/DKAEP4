package br.pro.aguiar.dkaep4.ui.lista

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.pro.aguiar.dkaep4.adapter.FilmeRecyclerAdapter
import br.pro.aguiar.dkaep4.model.Filme
import com.google.firebase.firestore.FirebaseFirestore

class ListaViewModel : ViewModel() {
    fun setupRecyclerView(
        recyclerView: RecyclerView, context: Context, pgrBar: ProgressBar
    ){
        pgrBar.visibility = View.VISIBLE
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val collection = firebaseFirestore.collection("filme")
        val task = collection.get()
        task.addOnSuccessListener {
            if (it != null){
                val filmes = it.toObjects(Filme::class.java)
                recyclerView.adapter = FilmeRecyclerAdapter(filmes)
                recyclerView.layoutManager = LinearLayoutManager(context)
            }
            pgrBar.visibility = View.GONE
        }.addOnFailureListener {
            pgrBar.visibility = View.GONE
            Toast.makeText(
                context, it.message, Toast.LENGTH_LONG
            ).show()
        }
    }

}