package br.ufpe.cin.models;

public class HomeHTML {
    private String html = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "\n" +
            "<head>\n" +
            "\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "    <meta name=\"description\" content=\"\">\n" +
            "    <meta name=\"author\" content=\"\">\n" +
            "\n" +
            "    <title>MPManager</title>\n" +
            "\n" +
            "    <!-- Bootstrap Core CSS -->\n" +
            "    <link href=\"http://cin.ufpe.br/~pglj2/apsutil/bootstrap.min.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "    <!-- Custom CSS -->\n" +
            "    <link href=\"http://cin.ufpe.br/~pglj2/apsutil/business-frontpage.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n" +
            "    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n" +
            "    <!--[if lt IE 9]>\n" +
            "        <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n" +
            "        <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n" +
            "    <![endif]-->\n" +
            "\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "\n" +
            "    <!-- Navigation -->\n" +
            "    <nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\">\n" +
            "        <div class=\"container\">\n" +
            "            <!-- Brand and toggle get grouped for better mobile display -->\n" +
            "            <div class=\"navbar-header\">\n" +
            "                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n" +
            "                    <span class=\"sr-only\">Toggle navigation</span>\n" +
            "                    <span class=\"icon-bar\"></span>\n" +
            "                    <span class=\"icon-bar\"></span>\n" +
            "                    <span class=\"icon-bar\"></span>\n" +
            "                </button>\n" +
            "                <a class=\"navbar-brand\" href=\"#\">MPManager</a>\n" +
            "            </div>\n" +
            "            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n" +
            "                <ul class=\"nav navbar-nav\">\n" +
            "                    <li>\n" +
            "                        <a href=\"home\">Home</a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a href=\"atividades\">Atividades</a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </nav>\n" +
            "\t<h2> Bem Vindo ao MPManager!</h2>\n" +
            "    <header class=\"business-header\">\n" +
            "        <div class=\"container\">\n" +
            "            <div class=\"row\">\n" +
            "                <div class=\"col-lg-12\">\n" +
            "                    <h1 class=\"tagline\"></h1>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </header>\n" +
            "\n" +
            "\n" +
            "    <!-- jQuery -->\n" +
            "    <!-- <script src=\"js/jquery.js\"></script> -->\n" +
            "\n" +
            "    <!-- Bootstrap Core JavaScript -->\n" +
            "    <!-- <script src=\"js/bootstrap.min.js\"></script> -->\n" +
            "\n" +
            "</body>\n" +
            "\n" +
            "</html>\n";

    public String getHtml() {
        return html;
    }
}
