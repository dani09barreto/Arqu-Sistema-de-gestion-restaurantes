import { Ingrediente } from "./ingrediente.model";
import { PlatoRequest } from "./platoRequest.model";

export interface PlatoIngredienteResponse {
  ingredientes: Ingrediente[],
  plato : PlatoRequest

}
