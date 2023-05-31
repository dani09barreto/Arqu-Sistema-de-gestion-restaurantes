import { TipoIngrediente } from "./tipoIngrediente.model";

export interface Ingrediente {
    id:number,
    TipoIngredienteid: TipoIngrediente,
    nombre: string
}
