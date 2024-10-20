<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ma.fstm.ilisi.projetcaisse.metier.bo.Produit" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Les produits</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        #produits {
            list-style-type: none;
            padding: 0;
        }

        #produits li {
            background-color: #fff;
            border: 1px solid #ddd;
            margin: 5px;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <h1>Les produits :</h1>
    <ul id="produits">
        <% 
            List<Produit> produits = (List<Produit>) request.getAttribute("produits");
            if (produits != null && !produits.isEmpty()) {
                for (Produit produit : produits) {
        %>
            <li><%= produit.getDesignation() %></li>
        <%
                }
            }
        %>
    </ul>
</body>
</html>


