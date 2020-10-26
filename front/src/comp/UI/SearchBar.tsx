import React from "react"
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
    key: string,
    plist: Array<string>
}

class SearchBar extends React.PureComponent<InputGroupState> {
    public state: InputGroupState = {
        disabled: false,
        selected: '',
        cat: ['가전', '의류'],
        key: '',
        plist: []
    }

    public render() {
        const { cat, disabled, selected, key } = this.state

        const rightIcon = (
            <a href={`/searchResult?category=${selected}&keyword=${key}`} >
            <Button icon="search" intent="warning" onClick={this.handleSubmit} minimal /> 
            </a>
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
                    <h4>{selected === '' ? 'Category' : selected }</h4>
                </Button>
            </Popover>
        )

        return (
            <div className="search-bar">
                
                <InputGroup
                    disabled={disabled}
                    large
                    fill
                    placeholder="Promotions.."
                    leftElement={permissionsMenu}
                    rightElement={rightIcon}
                    onChange={(e:any) => this.setState({key: e.target.value})}
                    onKeyPress={(e:any) => this.handleKeyPress(e)}
                />
            </div>
        )
    }

    handleSubmit = () => {
    }

    handleKeyPress = (e:any) => {
        if (e.key === "Enter") {
         let url = `/searchResult?category=${this.state.selected}&keyword=${this.state.key}`
          window.location.href = url
        }
    }

}

export default SearchBar