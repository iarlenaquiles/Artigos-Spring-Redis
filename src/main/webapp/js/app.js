var options = {
	url : "/getClientes",

	getValue : "nome",

	list : {
		match : {
			enabled : true
		},

		onSelectItemEvent : function() {
			var value = $("#nomeCliente").getSelectedItemData().id;
			$("#idCliente").val(value).trigger("change");
		}
	}
};

var options2 = {
	url : "/getEstado",

	getValue : "nome",

	list : {
		match : {
			enabled : true
		},

		onSelectItemEvent : function() {
			var value = $("#estadoExpedicaoRg").getSelectedItemData().id;
			$("#idEstadoExpedicaoRg").val(value).trigger("change");
		}
	}
};

var options3 = {
	url : "/getEstado",

	getValue : "nome",

	list : {
		match : {
			enabled : true
		},

		onSelectItemEvent : function() {
			var value = $("#estadoExpedicaoCtps").getSelectedItemData().id;
			$("#idEstadoExpedicaoCtps").val(value).trigger("change");
		}
	}
};

var options4 = {
	url : "/getEstado",

	getValue : "nome",

	list : {
		match : {
			enabled : true
		},

		onSelectItemEvent : function() {
			var value = $("#estado").getSelectedItemData().id;
			$("#idestado").val(value).trigger("change");
		}
	}
};

var options5 = {
	url : "/getCidade",

	getValue : "nome",

	list : {
		match : {
			enabled : true
		},

		onSelectItemEvent : function() {
			var value = $("#cidade").getSelectedItemData().id;
			$("#idcidade").val(value).trigger("change");
		}
	}
};

var options6 = {
	url : "/getCidade",

	getValue : "nome",

	list : {
		match : {
			enabled : true
		}
	}
};

var options7 = {
	url : "/getCidade",

	getValue : "nome",

	list : {
		match : {
			enabled : true
		},
		onSelectItemEvent : function() {
			var value = $("#cidade_comarca").getSelectedItemData().estado.nome;

			$("#estado_comarca").val(value).trigger("change");
		}
	}
};

$.get("/qtdClientes", function(responseText) {

	$("#qtd_cliente").text(responseText);

});

$.get("/qtdContatos", function(responseText) {

	$("#qtd_contato").text(responseText);

});

$.get("/qtdProcessos", function(responseText) {

	$("#qtd_processo").text(responseText);

});

$.get("/qtdUsuarios", function(responseText) {

	$("#qtd_usuario").text(responseText);

});

function mostra_estado(estado) {

	for ( var i in estado) {
		var e = estado[i]
		$("#estadoExpedicaoRg").append(
				"<option value='" + e.id + "'>" + e.nome + "</option>");
	}
}

function mostra_cidade(cidade) {

	for ( var i in cidade) {
		var c = cidade[i]
		$("#cidade").append(
				"<option value='" + c.id + "'>" + c.nome + "</option>");
	}
}

$.get("/getCidade", function(response) {
	mostra_cidade(response);
});

$("#cidade_comarca").easyAutocomplete(options7);
$("#naturalidade").easyAutocomplete(options6);
$("#cidade").easyAutocomplete(options5);
$("#estado").easyAutocomplete(options4);
$("#estadoExpedicaoRg").easyAutocomplete(options2);
$("#estadoExpedicaoCtps").easyAutocomplete(options3);
$("#nomeCliente").easyAutocomplete(options);
