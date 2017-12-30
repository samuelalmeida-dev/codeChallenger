angular.module('pessoaApp').controller('PessoaCtrl', PessoaCtrl);

function PessoaCtrl($scope, PessoaService) {

	$scope.pessoa = {};
	$scope.listaPessoas = [];
	
	buscarPessoas();
	
	$scope.savePessoa = function (pessoa){

		if(pessoa.id != null){
			
			PessoaService.update(pessoa, function (data){
				buscarPessoas();
			}, function (e){
				 console.log(e);
			});
			
		}else{
			PessoaService.save(pessoa, function (){
				buscarPessoas();

			} , function (e){
				console.log(e);
			});
		}

		$scope.pessoa = {};
		
	}


	$scope.preencherPessoa = function (pessoa){
		$scope.pessoa = angular.copy(pessoa);
	}

	$scope.limparCampos = function (){
		$scope.pessoa = {};
	}

	function buscarPessoas(){
		PessoaService.query({}, function (data){
			$scope.listaPessoas = data;
		}, function(e){
			console.log(e);
		})
	}

	$scope.deletarPessoa = function (id){
		
		PessoaService.delete({id: id}, function (data){
			buscarPessoas();
		}, function (e) {
			console.log(e);
		});

		
	}
}