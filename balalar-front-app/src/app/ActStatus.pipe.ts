import { Pipe, PipeTransform } from '@angular/core';
import {CommonModule} from "@angular/common";

import { DomSanitizer } from '@angular/platform-browser';

@Pipe({
    name: 'safe'
  })
  export class ActStatusPipe implements PipeTransform{
    transform(url) {
        return this.sanitizer.bypassSecurityTrustResourceUrl(url);
      }
      constructor(public sanitizer: DomSanitizer) { }
  }