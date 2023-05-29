import { Plato } from "./plato.model";

export interface Menu {
  id: number;
  nombre: string;
  platos: Plato[];
}
