<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ma.fstm.ilisi.projetcaisse.metier.bo.Categorie" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Caisse - Catégorie</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        label {
            font-size: 16px;
            margin-right: 10px;
        }

        select {
            padding: 8px;
            font-size: 14px;
            width: 200px; 
        }

        script {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>Sélectionner une catégorie :</h1>
    <label for="categorie">Catégorie :</label>
    <select id="categorie" onchange="afficherProduits()">
        <%
        @SuppressWarnings("unchecked")
        List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
        for (Categorie categorie : categories) {
        %>
        <option value="<%= categorie.getIdCategorie() %>"><%= categorie.getNomCategorie() %></option>
        <%
        }
        %>
    </select>

    <script>
        function afficherProduits() {
            var idCategorie = document.getElementById("categorie").value;
            window.location.href = '/CaisseSupermarche/ProduitsServlet?idCategorie=' + idCategorie;
        }
    </script>
</body>
</html>
