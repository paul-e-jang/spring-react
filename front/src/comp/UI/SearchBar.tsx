import * as React from "react"

import { Button, ControlGroup, HTMLSelect, InputGroup} from "@blueprintjs/core"

export interface IControlGroupExampleState {
    fill: boolean;
    vertical: boolean;
}

const FILTER_OPTIONS = ["Category", "Clothes", "Electronics"]

export default class ControlGroupExample extends React.PureComponent<IControlGroupExampleState> {
    public state: IControlGroupExampleState = {
        fill: false,
        vertical: false,
    }

    public render() {

        return (
        <div className="search-bar">
          <ControlGroup {...this.state}>
              <HTMLSelect large options={FILTER_OPTIONS} className="search-bar-content"/>
              <InputGroup large fill placeholder="Promotions"/>
              <Button large icon="search" intent="warning" />
          </ControlGroup>
        </div>
        )
    }
}