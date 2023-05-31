import { PlatoResponse } from './platoResponse.model';
import { Usuario } from './usuario.model';
import { UsuarioResponse } from './usuarioResponse.model';

export interface PedidoResponse {
  mesaId: number;
  cliente: UsuarioResponse;
  platos: PlatoResponse[];
}
