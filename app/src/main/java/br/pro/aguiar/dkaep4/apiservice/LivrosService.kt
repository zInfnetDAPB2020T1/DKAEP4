package br.pro.aguiar.dkaep4.apiservice

import br.pro.aguiar.dkaep4.model.Livro
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface LivrosService {

    // Listar todos os Recursos
    @GET("api/livros")
    fun all() : Call<List<Livro>>
    /* URL                          + Recurso    // URI
    // http://biblio.aguiar.pro.br  + api/livros
    // http://biblio.aguiar.pro.br/api/livros
        [
            {LivroA},
            {LivroB},
            ...
        ]
     */

    // Criar um Livro       | POST                      | Body Livro

    // Atualizar um Livro   | PUT       | Variavel ID   | Body Livro

    // Exibir um Livro      | GET       | Variavel ID
    /*
        api/livros/{id_livro}/autores/{id_autor}
        fun show(
                @Path("id_livro") livro_id: Int,
                @Path("id_autor") autor_id: Int
            )

    // http://biblio.aguiar.pro.br/api/livros/30*/
    @GET("api/livros/{id}")
    fun show(@Path("id") id: Int) : Call<Livro>

    // Excluir um Livro     | DELETE    | Variavel ID

}