package br.pro.aguiar.dkaep4.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import br.pro.aguiar.dkaep4.R
import kotlinx.android.synthetic.main.fragment_sign_up.*

/**
 * A simple [Fragment] subclass.
 */
class SignUpFragment : Fragment() {

    lateinit var authViewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_sign_up,
            container, false)
    }

    // Instanciar a ViewModel
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            authViewModel = ViewModelProviders.of(it)
                .get(AuthViewModel::class.java)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCadastroCadastrar.setOnClickListener {
            authViewModel.createUser(
                edtTxtCadastroEmail,
                edtTxtCadastroSenha,
                edtTxtCadastroRepetirSenha
            )
        }

    }



}