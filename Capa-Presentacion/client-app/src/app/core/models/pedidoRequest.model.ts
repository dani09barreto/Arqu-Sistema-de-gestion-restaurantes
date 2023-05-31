import { PlatoIngredienteResponse } from "./platoIngredienteResponse.model";

export interface PedidoRequest {
    idPedido: number,
    lista_plato: PlatoIngredienteResponse[]
}
