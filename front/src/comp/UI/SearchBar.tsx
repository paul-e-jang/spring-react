import React from "react"
import {Link} from 'react-router-dom'

import {
    Button,
    InputGroup,
    Menu,
    MenuItem,
    Popover,
    Position
} from "@blueprintjs/core"

export interface InputGroupState {
    disabled: boolean,
    selected: string,
    cat: Array<string>,
    keyword: string
}

export default class SearchBar extends React.PureComponent<InputGroupState> {
    public state: InputGroupState = {
        disabled: false,
        selected: 'base',
        cat: ['Electronics', 'clothes'],
        keyword: 'base',
    }

    public render() {
        const { cat, disabled, selected } = this.state

        const rightIcon = (
            <Button icon="search" intent="warning" minimal />
        )

        const permissionsMenu = (
            <Popover
                content={
                    <Menu>
                        <MenuItem text={cat[0]} onClick={ (e:any) => this.setState({selected: cat[0]})} />
                        <MenuItem text={cat[1]} onClick={ (e:any) => this.setState({selected: cat[1]})}/>
                    </Menu>
                }
                disabled={disabled}
                position={Position.BOTTOM_RIGHT}
            >
                <Button disabled={disabled} minimal={true} rightIcon="caret-down">
                    <h4>{selected === 'base' ? 'Category' : selected }</h4>
                </Button>
            </Popover>
        )
        return (
            <div className="search-bar">
                <Link to="searchResult" >
                <InputGroup
                    disabled={disabled}
                    large
                    fill
                    placeholder="Promotions"
                    leftElement={permissionsMenu}
                    rightElement={rightIcon}
                    onChange={(e:React.ChangeEvent<HTMLInputElement>) => this.setState({keyword: e.target.value})}
                />
                </Link>
            </div>
        )
    }

}