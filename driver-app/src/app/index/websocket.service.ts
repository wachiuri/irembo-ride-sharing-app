// src\app\services\websocket.service.ts
import { Injectable, inject } from "@angular/core";
import { BehaviorSubject, Observable, Observer, combineLatest, zip } from 'rxjs';
import { AnonymousSubject } from 'rxjs/internal/Subject';
import { Subject } from 'rxjs';
import { catchError, combineLatestWith, concatAll, map, mergeMap } from 'rxjs/operators';
import { ApplicationHttpService } from "../lib/http/application-http.service";

export interface Message {
  source: string;
  data: any;
}

@Injectable()
export class WebsocketService {
  private subject!: AnonymousSubject<MessageEvent>;
  public messages: Subject<Message> = new BehaviorSubject({
    source: '',
    data: ''
  });

  private httpService = inject(ApplicationHttpService);

  constructor() {
    this.messages = <Subject<Message>>this.connect(this.httpService.getWebsocketUrl()).pipe(
      map(
          (response: MessageEvent): Message => {
              console.log(response.data);
              let data = JSON.parse(response.data)
              return data;
          }
      )
  );
  }

  public connect(url: string): AnonymousSubject<MessageEvent> {
    if (!this.subject) {
      this.subject = this.create(url);
      console.log("Successfully connected: " + url);
    }
    return this.subject;
  }

  private create(url: string | URL): AnonymousSubject<MessageEvent> {
    let ws = new WebSocket(url);

    let observable = new Observable((obs: Observer<MessageEvent>) => {
      ws.onmessage = obs.next.bind(obs);
      ws.onerror = obs.error.bind(obs);
      ws.onclose = obs.complete.bind(obs);
      return ws.close.bind(ws);
    });
    let observer = {
      error: (err: any) => { },
      complete: () => { },
      next: (data: Object) => {
        console.log('Message sent to websocket: ', data);
        if (ws.readyState === WebSocket.OPEN) {
          ws.send(JSON.stringify(data));
        }
      }
    };
    return new AnonymousSubject<MessageEvent>(observer, observable);
  }
}
