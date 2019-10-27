Feature: Buscar no google o diretor e o filme e retorne a quantidade aproximada de resultados para a busca.

  Scenario: Capturar no google o data de nascimento 'Joe Russo'
    Given que navego na url do google
    When insiro no campo de perquisa 'Joe Russo'
    Then clico no botao 'Pesquisa Google'

  Scenario: Capturar no google o data de nascimento 'Joss Whedon'
    Given que navego na url do google
    When insiro no campo de perquisa 'Joss Whedon'
    Then clico no botao 'Pesquisa Google'

  Scenario: Capturar no google o data de nascimento 'Anthony Russo'
    Given que navego na url do google
    When insiro no campo de perquisa 'Anthony Russo'
    And clico no botao 'Pesquisa Google'
    Then capturo a data de nascimento do 'Anthony Russo'
