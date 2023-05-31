import { PedidoResponse } from "./pedidoResponse";

export interface PagoRequest {
  valor: number;
  tipoPago: string;
  pedido: PedidoResponse;
  adiciones: string[];
}
