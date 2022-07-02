# States API
API desenvolvida como método de avaliação para a 3° Sprint

### Dependências:
- Spring Data JPA
- Spring Web
- Spring Validation
- H2 Database

### Endpoints
Acessíveis em `localhost:8080`
| Método | Caminho | Descrição |
|---|---|---|
| `GET` | /api/states | Retorna informações de todos os registros. |
| `POST` | /api/states | Criar um novo registro. |
| `GET` | /api/states/{id} | Retorna informações de um registro. |
| `PUT` | /api/states/{id} | Atualiza dados de um registro. |
| `DELETE` | /api/states/{id} | Remove um registro. |

### Filtros
A aplicação permite aplicar os seguintes filtros para as ações de `listagem`:
| Filtro| Exemplo de caminho |
|---|---|
| Exibir estados por região | /api/states?region=Nordeste |
| Ordenar estados pela maior população | api/states?sort=population,desc |
| Ordenar estados pela menor população | api/states?sort=population,asc |
| Ordenar estados pela maior área | /api/states?sort=area,desc |
| Ordenar estados pela menor área | /api/states?sort=area,asc |
