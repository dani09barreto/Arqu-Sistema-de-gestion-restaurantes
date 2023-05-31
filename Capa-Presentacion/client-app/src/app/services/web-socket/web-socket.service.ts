// frontend/src/app/websocket.service.ts
import { Injectable } from '@angular/core';
import { webSocket, WebSocketSubject } from 'rxjs/webSocket';

interface MessageData {
  message: string;
  time?: string;
}

@Injectable({
  providedIn: 'root',
})
export class WebSocketService {
  private socket$!: WebSocketSubject<any>;
  public receivedData: MessageData[] = [];
  socket: any;

  public connect(): void {
    if (!this.socket$ || this.socket$.closed) {
      this.socket$ = webSocket("ws://192.168.211.144:8200/websocket-path");

      this.socket$.subscribe((data: MessageData) => {
        this.receivedData.push(data);
        console.log(this.receivedData.push(data));
      });
    }
  }

  sendMessage(message: string) {
    this.socket$.next({ message });
  }

  onExternalEvent() {
    return this.socket.fromEvent('external-event');
  }

  close() {
    this.socket$.complete();
  }
}
