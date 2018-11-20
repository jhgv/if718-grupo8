package br.ufpe.cin.models;

public class ProfessorHTML {
    private String html = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta charset=\"utf-8\" />\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <title>Sistema de Acompanhamento Escolar</title>\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n" +
            "\n" +
            "</head>\n" +
            "<body>\n" +
            "\n" +
            "    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n" +
            "        <a class=\"navbar-brand\" href=\"#\">Sistema Escolar</a>\n" +
            "        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
            "            <span class=\"navbar-toggler-icon\"></span>\n" +
            "        </button>\n" +
            "        \n" +
            "        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
            "            <ul class=\"navbar-nav mr-auto\">\n" +
            "            <li class=\"nav-item active\">\n" +
            "                <a class=\"nav-link\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\n" +
            "            </li>\n" +
            "            <li class=\"nav-item\">\n" +
            "                <a class=\"nav-link\" href=\"/professores/\">Professores</a>\n" +
            "            </li>\n" +
            "            <li class=\"nav-item\">\n" +
            "                    <a class=\"nav-link\" href=\"#\">Alunos</a>\n" +
            "                </li>\n" +
            "            <li class=\"nav-item\">\n" +
            "                    <a class=\"nav-link\" href=\"#\">Responsáveis</a>\n" +
            "                </li>\n" +
            "                <li class=\"nav-item\">\n" +
            "                        <a class=\"nav-link\" href=\"#\">Cobranças</a>\n" +
            "                    </li>\n" +
            "    \n" +
            "            </ul>\n" +
            "            <form class=\"form-inline my-2 my-lg-0\">\n" +
            "            <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\n" +
            "            <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n" +
            "            </form>\n" +
            "        </div>\n" +
            "    </nav>\n" +
            "\n" +
            "    <div class=\"container\">\n" +
            "    <div class=\"row\" style=\"margin-top: 30px;\">\n" +
            "\n" +
            "        <div class=\"col-md-12\">\n" +
            "            <h3>Lista professor</h3>\n" +
            "            <a class=\"btn btn-primary\" style=\"margin-bottom: 15px;\" href=\"/cadastroProfessor/\">Cadastrar professor</a>\n" +
            "            <table class=\"table\">\n" +
            "            <thead>\n" +
            "            <tr>\n" +
            "                <th scope=\"col\">Nome</th>\n" +
            "                <th scope=\"col\">Email</th>\n" +
            "                <th scope=\"col\">Ação</th>\n" +
            "            </tr>\n" +
            "            </thead>\n" +
            "            <tbody>\n" +
            "             %s" +
            "            </tbody>\n" +
            "            </table>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "    </div>\n" +
            "\n" +
            "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n" +
            "\n" +
            "</body>\n" +
            "</html>";

    public String getHtml() {
        return html;
    }

    public String formatString(String professor) {
        return String.format(html, professor);
    }
}
