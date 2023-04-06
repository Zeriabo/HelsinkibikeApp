import React, { Component } from "react";

export default class AsematList extends Component {
  constructor(props) {
    console.log(props.asemat);
    super(props.asemat);
    this.onChangeSearchTitle = this.onChangeSearchTitle.bind(this);
    this.retrieveTutorials = this.retrieveTutorials.bind(this);
    this.handlePageChange = this.handlePageChange.bind(this);
    this.handlePageSizeChange = this.handlePageSizeChange.bind(this);
    this.setActiveTutorial = this.setActiveTutorial.bind(this);

    this.state = {
      content: props.asemat.content,
      empty: props.asemat.empty,
      first: props.asemat.first,
      last: props.asemat.last,
      number: props.asemat.number,
      numberOfElements: props.asemat.numberOfElements,
      pageable: props.asemat.pageable,
      size: props.asemat.size,
      sort: props.asemat.sort,
      totalElements: props.asemat.totalElements,
      totalPages: props.asemat.totalPages,
    };
  }

  componentDidMount() {
    this.retrieveTutorials();
  }

  onChangeSearchTitle(e) {
    const searchTitle = e.target.value;

    this.setState({
      searchTitle: searchTitle,
    });
  }

  getRequestParams(searchTitle, page, pageSize) {
    let params = {};

    if (searchTitle) {
      params["title"] = searchTitle;
    }

    if (page) {
      params["page"] = page - 1;
    }

    if (pageSize) {
      params["size"] = pageSize;
    }

    return params;
  }

  retrieveTutorials() {
    console.log(this.state);
    const { searchTitle, page, pageSize } = this.state;
    const params = this.getRequestParams(searchTitle, page, pageSize);
  }

  handlePageChange(event, value) {
    this.setState(
      {
        page: value,
      },
      () => {
        this.retrieveTutorials();
      }
    );
  }
  setActiveTutorial(event) {
    console.log(event);
  }
  handlePageSizeChange(event) {
    this.setState(
      {
        pageSize: event.target.value,
        page: 1,
      },
      () => {
        this.retrieveTutorials();
      }
    );
  }
  render() {
    return (
      <div className="list row">
        <div className="col-md-8">
          <div className="input-group mb-3">
            <input
              type="text"
              className="form-control"
              placeholder="Search by title"
              value={this.state.first}
              onChange={this.onChangeSearchTitle}
            />
            <div className="input-group-append">
              <button
                className="btn btn-outline-secondary"
                type="button"
                onClick={this.retrieveTutorials}
              >
                Search
              </button>
            </div>
          </div>
        </div>
        <div className="col-md-6">
          <h4>Tutorials List</h4>

          <div className="mt-3">
            {"Items per Page: "}
            <select
              onChange={this.handlePageSizeChange}
              value={this.state.totalPages}
            ></select>

            <div
              className="my-3"
              count={this.state.totalElements}
              page={this.state.content}
              siblingCount={1}
              boundaryCount={1}
              variant="outlined"
              shape="rounded"
              onChange={this.handlePageChange}
            />
          </div>

          <ul className="list-group">
            {this.state.content &&
              this.state.content.map((tutorial, index) => (
                <li
                  onClick={() => this.setActiveTutorial(tutorial, index)}
                  key={index}
                >
                  {tutorial.name}
                </li>
              ))}
          </ul>
        </div>
      </div>
    );
  }
}
