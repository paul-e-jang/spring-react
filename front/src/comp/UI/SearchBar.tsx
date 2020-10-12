import React from "react"
import {Link} from 'react-router-dom'
import productService from '../../services/product'

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
    key: string
}

class SearchBar extends React.PureComponent<InputGroupState> {
    public state: InputGroupState = {
        disabled: false,
        selected: 'base',
        cat: ['electronics', 'clothes'],
        key: 'base',
    }

    public render() {
        const { cat, disabled, selected } = this.state

        const rightIcon = (
            <Link to="/searchResult">
            <Button icon="search" intent="warning" onClick={this.handleSubmit} minimal /> 
            </Link>
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
                
                <InputGroup
                    disabled={disabled}
                    large
                    fill
                    placeholder="Promotions"
                    leftElement={permissionsMenu}
                    rightElement={rightIcon}
                    onChange={(e:any) => this.setState({key: e.target.value})}
                />
            </div>
        )
    }

    handleSubmit = () => {
        const data = productService.Search(this.state.key, this.state.selected)
        console.log(data)
    }

}

export default SearchBar